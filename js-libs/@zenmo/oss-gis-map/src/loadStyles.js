import maptilerCss from "@maptiler/sdk/dist/maptiler-sdk.css" with {type: "css"}
import compassCss from "./compass.css" with {type: "css"}

let stylesLoaded = false
export function loadStyles() {
    if (stylesLoaded) return

    if (!(maptilerCss instanceof CSSStyleSheet)) {
        console.error("Styles not loaded because styles is not a CSSStyleSheet instance. This is a problem with the bundler.")
        return
    }

    document.adoptedStyleSheets.push(maptilerCss)
    document.adoptedStyleSheets.push(compassCss)
    stylesLoaded = true
}
