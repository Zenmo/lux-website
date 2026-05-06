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

    /**
     * @type {Promise<Map>}
     */
    const mapPromise = new Promise((resolve, reject) => {
        const map = new Map({
            container: element,
            style: `https://api.maptiler.com/maps/${OSS_MAP_STYLE_ID}/style.json?key=${API_KEY}`,
            center: OSS_CENTER,
            zoom: 12,
            pitch: 60,
            navigationControl: false,
            geolocateControl: false,
            attributionControl: false,
            forceNoAttributionControl: true,
            maptilerLogo: false,
        })

        map.on("load", () => {
            let animationFrameId;

            function rotate() {
                map.setBearing((map.getBearing() + 0.1) % 360);
                animationFrameId = requestAnimationFrame(rotate);
            }

            rotate();

            map.on("remove", () => {
                cancelAnimationFrame(animationFrameId);
            });

            resolve(map)
        })
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
                .map((a, i) => ({
                    ...a.geojson,
                    id: i,
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
            "fill-opacity": ["case", ["boolean", ["feature-state", "hover"], false], 0.6, 0.3]
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

    map.addLayer({
        id: "areas-labels",
        type: "symbol",
        source: "areas",
        layout: {
            "text-field": ["get", "name"],
            "text-size": 14,
        },
        paint: {
            "text-color": luxTeal,
            "text-halo-color": "white",
            "text-halo-width": 2
        }
    })

    addMapClick(map)
    addMapHoover(map)

    return map
}

function addMapClick(map) {
    map.on("click", "areas-fill", (e) => {
        const url = e.features[0].properties.url
        if (url) {
            window.open(url, "_self")
        }
    })
}

function addMapHoover(map) {
    let hoveredFeatureId = null

    map.on("mouseenter", "areas-fill", event => {
        map.getCanvas().style.cursor = "pointer"
        if (event.features.length > 0) {
            if (hoveredFeatureId !== null) {
                map.setFeatureState({ source: "areas", id: hoveredFeatureId }, { hover: false })
            }
            hoveredFeatureId = event.features[0].id
            map.setFeatureState({ source: "areas", id: hoveredFeatureId }, { hover: true })
        }
    })

    map.on("mouseleave", "areas-fill", () => {
        map.getCanvas().style.cursor = ""
        if (hoveredFeatureId !== null) {
            map.setFeatureState({ source: "areas", id: hoveredFeatureId }, { hover: false })
            hoveredFeatureId = null
        }
    })
}
