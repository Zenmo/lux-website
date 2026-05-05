import {featureCollection} from "@turf/helpers"

/**
 * @param buurtCodes {string[]}
 * @returns {Promise<import("geojson").FeatureCollection>}
 */
export async function fetchBuurtenByCodes(buurtCodes) {
    if (buurtCodes.length === 0) {
        return featureCollection([])
    }

    if (buurtCodes.length === 1) {
        return await fetchBuurten(`
            <Filter>
                <PropertyIsEqualTo>
                    <PropertyName>buurtcode</PropertyName>
                    <Literal>${buurtCodes[0]}</Literal>
                </PropertyIsEqualTo>
            </Filter>
    `)
    }

    return await fetchBuurten(`
        <Filter>
            <Or>
                ${buurtCodes.map(code => `
                    <PropertyIsEqualTo>
                        <PropertyName>buurtcode</PropertyName>
                        <Literal>${code}</Literal>
                    </PropertyIsEqualTo>
                `)}
            </Or>
        </Filter>
    `)
}

/**
 * @param xmlFilter {string}
 * @returns {Promise<import("geojson").FeatureCollection>}
 */
export async function fetchBuurten(xmlFilter) {
    const params = new URLSearchParams({
        request: "GetFeature",
        typeName: "buurten",
        service: "WFS",
        version: "2.0.0",
        outputFormat: "json",
        srsName: "EPSG:4326", // output coordinate system
        filter: xmlFilter,
    })

    const url = "https://service.pdok.nl/cbs/wijkenbuurten/2025/wfs/v1_0?" + params.toString()
    const response = await fetch(url)
    if (response.status !== 200) {
        throw Error("Failure getting buurt geometry")
    }

    return await response.json()
}
