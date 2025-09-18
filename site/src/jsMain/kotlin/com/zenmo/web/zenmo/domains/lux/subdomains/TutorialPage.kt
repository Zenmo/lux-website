package com.zenmo.web.zenmo.domains.lux.subdomains

import androidx.compose.runtime.Composable
import com.zenmo.web.zenmo.domains.lux.components.ProfileContactCard
import com.zenmo.web.zenmo.domains.lux.components.layout.LuxSubdomainPageLayout
import com.zenmo.web.zenmo.domains.lux.components.model.ModelPageContent
import com.zenmo.web.zenmo.domains.lux.components.model.SubdomainModel
import com.zenmo.web.zenmo.domains.zenmo.sections.team.ZenmoTeam

@Composable
fun TutorialModelPage() {
    LuxSubdomainPageLayout(
        title = "Page title",
    ) {
        ModelPageContent(
            twin = SubdomainModel.TutorialModel,
            enHeaderText = "Some Lux Model",
            nlHeaderText = "Een Lux Model",
            enDescriptionParagraph = "Roses are red, violets are blue",
            nlDescriptionParagraph = "Rozen zijn rood, viooltjes zijn blauw",
            enSubHeaderText = "This is a subheader",
            nlSubHeaderText = "Dit is een subheader",
        ) {
            ProfileContactCard(
                name = ZenmoTeam.ATE.memberName,
                imageUrl = ZenmoTeam.ATE.image,
                email = ZenmoTeam.ATE.email,
                telephoneNumber = "+31 6 15249535",
                enSubtitle = "Website and model development",
                nlSubtitle = "Website en model ontwikkeling",
            )
        }
    }
}