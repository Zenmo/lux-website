import {config, Map} from "@maptiler/sdk"
import {loadStyles} from "./loadStyles.js"

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
    return new Promise((resolve, reject) => {
        const map = new Map({
            container: element,
            style: `https://api.maptiler.com/maps/${OSS_MAP_STYLE_ID}/style.json?key=${API_KEY}`,
            center: OSS_CENTER,
            zoom: 12,
        })

        map.on("load", () => resolve(map))
        map.on("error", (e) => reject(e.error ?? e))
    })
}

