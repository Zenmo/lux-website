import dynamicImportVars from '@rollup/plugin-dynamic-import-vars';
import nodeResolve from "@rollup/plugin-node-resolve";
import path from 'node:path';
import {fileURLToPath} from 'node:url';

const rootProjectDir = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..", "..")

/**
 * @type {import('rollup').RollupOptions}
 */
export default {
    input: path.resolve(rootProjectDir, "build/js/packages/zenmo-site/kotlin/zenmo-site/main.export.mjs"),
    output: {
        dir: path.resolve(rootProjectDir, "site/build/rollup"),
        format: "module",
        entryFileNames: "[name].mjs",
        chunkFileNames: "[name]-[hash].mjs",
        sourcemap: "hidden",
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
