import {config, Map} from "@maptiler/sdk"
import {loadStyles} from "./loadStyles.js"
import {areas, enrichAreasWithGeometry} from "./areas.js"

const OSS_CENTER = [5.53289, 51.76151] // [longitude, latitude]
const OSS_MAP_STYLE_ID = "019df291-09a3-786a-8db0-8690f20fc678"
// this key is scoped to the lux.energy domain
const API_KEY = "S8NEGvpNTQfDtgupaYkg"

config.apiKey = API_KEY;

/**
 * @param element {HTMLElement}
 * @returns {Promise<Map>}
 */
export async function showOssMap(element) {
    loadStyles()
    const mapPromise = new Promise((resolve, reject) => {
        const map = new Map({
            container: element,
            style: `https://api.maptiler.com/maps/${OSS_MAP_STYLE_ID}/style.json?key=${API_KEY}`,
            center: OSS_CENTER,
            zoom: 12,
        })

        map.on("load", () => resolve(map))
        map.on("error", (e) => reject(e.error ?? e))
    })

    const [map, enriched] = await Promise.all([
        mapPromise,
        enrichAreasWithGeometry(areas)
    ])

    map.addSource("areas", {
        type: "geojson",
        data: {
            type: "FeatureCollection",
            features: enriched
                .map(a => ({
                    ...a.geojson,
                    properties: {
                        ...a.geojson.properties,
                        name: a.name,
                        url: a.url
                    }
                }))
        }
    })

    const luxTeal = "rgb(0, 126, 132)"

    map.addLayer({
        id: "areas-fill",
        type: "fill",
        source: "areas",
        paint: {
            "fill-color": luxTeal,
            "fill-opacity": 0.4
        }
    })

    map.addLayer({
        id: "areas-outline",
        type: "line",
        source: "areas",
        paint: {
            "line-color": luxTeal,
            "line-width": 2
        }
    })

    return map
}

