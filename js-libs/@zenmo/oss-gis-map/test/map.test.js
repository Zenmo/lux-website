import {showOssMap} from "../src/index.js";

describe('showOssMap', () => {
    let container;

    beforeEach(() => {
        container = document.createElement('div');
        container.style.width = '800px';
        container.style.height = '600px';
        document.body.appendChild(container);
    });

    afterEach(() => {
        container.remove();
    });

    it('renders the map of Oss and rotates it without controls', async () => {
        const map = await showOssMap(container);
        expect(map).toBeTruthy();
        expect(map.getPitch()).toBe(60);

        // Verify that controls are hidden
        const controls = container.querySelectorAll('.maplibregl-ctrl');
        expect(controls.length).toBe(0);

        const bearing1 = map.getBearing();
        // Wait for a few frames to ensure rotation is happening
        await new Promise(resolve => setTimeout(resolve, 100));
        const bearing2 = map.getBearing();

        expect(bearing2).toBeGreaterThan(bearing1);
        map.remove();
    });
});
