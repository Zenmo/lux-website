import {fetchBuurtenByCodes} from "./buurtwfs.js";
import union from "@turf/union";

/**
 * @typedef {{name: string, url: string, buurtCodes: string[]}} Area
 */

/**
 * @typedef {Area & {geojson: import("geojson").Feature}} AreaWithGeometry
 */

/** @type {Area[]} */
export const areas = [
    {
        name: "Elzenburg-De Geer",
        url: "/elzenburg-de-geer",
        buurtCodes: [
            "BU08280500", // Elzenburg
            "BU08280503", // De Geer
        ],
    }, {
        name: "Vorstengrafdonk",
        url: "/vorstengrafdonk",
        buurtCodes: [
            "BU08280909", // Vorstengraf
        ],
    }, {
        name: "Moleneind",
        url: "/moleneind",
        buurtCodes: [
            "BU08280200", // Moleneind
            "BU08280303", // Zeeheldenbuurt II
        ],
    }, {
        name: "Euterpepark",
        url: "/euterpepark",
        buurtCodes: [
            "BU08280605", // Euterpelaan-Noord
        ],
    },
]

/**
 * Enriches the given areas with their corresponding GeoJSON geometry by fetching
 * the buurten for all areas at once and merging them per area.
 *
 * @param {Area[]} areas
 * @returns {Promise<AreaWithGeometry[]>}
 * @throws {Error} if a buurt code is not found
 */
export async function enrichAreasWithGeometry(areas) {
    const allBuurtCodes = [...new Set(areas.flatMap(area => area.buurtCodes))];
    const buurtenFc = await fetchBuurtenByCodes(allBuurtCodes);
    const buurtMap = new Map(buurtenFc.features.map(f => [f.properties.buurtcode, f]));

    // Check if all requested buurten were found
    for (const code of allBuurtCodes) {
        if (!buurtMap.has(code)) {
            throw new Error(`Buurt with code ${code} not found`);
        }
    }

    return areas.map(area => {
        const areaBuurten = area.buurtCodes.map(code => buurtMap.get(code));
        const merged = areaBuurten.length > 1
            ? union({ type: "FeatureCollection", features: areaBuurten })
            : areaBuurten[0];

        return { ...area, geojson: merged };
    });
}
