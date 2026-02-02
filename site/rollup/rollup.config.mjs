import dynamicImportVars from '@rollup/plugin-dynamic-import-vars';
import nodeResolve from "@rollup/plugin-node-resolve";
import path from 'node:path';
import {fileURLToPath} from 'node:url';
import { globSync } from 'glob';
import "core-js/stable/array/to-sorted.js"

const rootProjectDir = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..", "..")

/**
 * @type {import('rollup').RollupOptions}
 */
export default {
    // Create an entry chunk for every Kotlin file with @JsExport annotation.
    // This ensures that those exports are present in the final bundles.
    // Rollup will de-duplicate across entry chunks.
    input: globSync(path.resolve(rootProjectDir, "build/js/packages/zenmo-site/kotlin/zenmo-site/**/*.export.mjs")),
    output: {
        dir: path.resolve(rootProjectDir, "site/build/rollup"),
        format: "module",
        entryFileNames: chunkInfo => {
            if (chunkInfo.facadeModuleId.endsWith("main.export.mjs")) {
                return "main.export.mjs"
            }
            return moduleIdToChunkName(chunkInfo.facadeModuleId) + "-[hash].mjs"
        },
        chunkFileNames: "[name]-[hash].mjs",
        sourcemap: "hidden",
        // Create a chunk for every module (= Kotlin file) which exports "accessPolicy".
        // (it is currently equivalent to check for the file extension *.export.mjs.)
        manualChunks: (moduleId, meta) => {
            const rootImporter = getFirstImporterWithAccessPolicy(moduleId, meta.getModuleInfo)
            return moduleIdToChunkName(rootImporter)
        },
        minifyInternalExports: false,
    },
    preserveEntrySignatures: "allow-extension",
    plugins: [
        nodeResolve({
            modulePaths: [
                path.resolve(rootProjectDir, "anylogic-cloud-client")
            ],
        }),
        dynamicImportVars(),
    ]
}

/**
 * This function finds the takes a module and searches it's importers
 * to find a module which has an Access Policy.
 * 
 * @param {string} moduleId
 * @param {import('rollup').GetModuleInfo} getModuleInfo
 * 
 * @returns string
 */
function getFirstImporterWithAccessPolicy(moduleId, getModuleInfo) {
    const importersWithAccessPolicy = breadthFirstSearch(
        moduleId,
        moduleId => getModuleInfo(moduleId).importers,
        moduleId => getModuleInfo(moduleId).exports.includes("accessPolicy")
    )

    if (!importersWithAccessPolicy.length === 0) {
        throw Error(`accessPolicy not found in importers of ${moduleId}`)
    }

    // Selecting the shortest module ensures that we prefer the public main.export.mjs entrypoint
    // rather than an entrypoint which is protected by role-based access control.
    // It would be more reliable to inspect the accessPolicy variable content but this is more complicated.
    return shortest(importersWithAccessPolicy)
}

/**
 * Name chunks so they're not all called "ProtectedComponent".
 * 
 * @param {string} moduleId 
 * @returns string
 */
function moduleIdToChunkName(moduleId) {
    const matches = moduleId.match(/(?<parentDir>[^\/]*)\/(?<name>[^\/]*)\.export\.mjs$/)
    if (!matches || matches.length === 0) {
        throw Error(`file does not match expected format: ${moduleId}`)
    }

    if (matches.groups.name === "main") {
        return "main.export"
    }

    if (matches.groups.name === "ProtectedComponent") {
        return matches.groups.parentDir
    }

    return matches.groups.name
}

/**
 * @param {Array<string>} stringArray 
 * @returns string
 */
function shortest(stringArray) {
    return stringArray.toSorted((left, right) => left.length - right.length)[0]
}

/**
 * Use a breadth-first search because it's good at dealing with cyclical dependencies.
 *
 * @template T
 * @param {T} startNode
 * @param {(T) => T[]} getNeighbors
 * @param {(T) => boolean} predicate
 * @returns {T[]}
 */
function breadthFirstSearch(startNode, getNeighbors, predicate) {
    const visited = new Set()
    const queue = [startNode]
    const result = []

    visited.add(startNode)

    while (queue.length > 0) {
        const node = queue.shift();

        // Check if this node matches our target
        if (predicate(node)) {
            result.push(node);
        }

        // Visit all neighbors
        const neighbors = getNeighbors(node);
        for (const neighbor of neighbors) {
            if (!visited.has(neighbor)) {
                visited.add(neighbor);
                queue.push(neighbor);
            }
        }
    }

    return result;
}
