package com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.pages.resregion

import com.varabyte.kobweb.core.init.InitKobwebContext
import com.zenmo.web.zenmo.domains.lux.subdomains.drechtsteden.DrechstedenTwin


fun resRegionRouting(
    ctx: InitKobwebContext
) {
    ctx.router.register("/res-region/${DrechstedenTwin.PMIEK.name}") {
        PmeikPage()
    }

}