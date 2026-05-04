import styles from "@maptiler/sdk/dist/maptiler-sdk.css" with {type: "css"}

let stylesLoaded = false
export function loadStyles() {
    if (stylesLoaded) return

    if (!(styles instanceof CSSStyleSheet)) {
        console.error("Styles not loaded because styles is not a CSSStyleSheet instance. This is a problem with the bundler.")
        return
    }

    document.adoptedStyleSheets.push(styles)
    stylesLoaded = true
}
