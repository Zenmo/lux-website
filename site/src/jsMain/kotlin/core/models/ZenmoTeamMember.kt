package energy.lux.frontend.core.models

enum class ZenmoTeamMember(
    val memberName: String,
    val enRole: String,
    val nlRole: String,
    val imageSrc: String,
    val email: String,
    val linkedIn: String = "",
    val twitter: String = "",
    val enBio: String = "",
    val nlBio: String = "",
) {
    AUKE(
        memberName = "Auke Hoekstra",
        enRole = "Director & founder",
        nlRole = "Directeur & oprichter",
        imageSrc = "/avatars/Auke_Hoekstra.jpg",
        email = "auke@zenmo.com",
        twitter = "AukeHoekstra",
        linkedIn = "https://www.linkedin.com/in/aukehoekstra/",
        enBio = """
            After twenty years as an independent consultant, Auke has been researching renewable energy and electric 
            mobility since 2010.
        """.trimIndent(),
        nlBio = """
            Na 20 jaar ervaring als zelfstandig consultant, doet Auke nu al sinds 2010 onderzoek naar duurzame energie 
            en elektrische mobiliteit.
        """.trimIndent(),
    ),
    PETER_HOGEVEEN(
        memberName = "Peter Hogeveen",
        enRole = "Technical Director & Co-Founder",
        nlRole = "Technisch Directeur & Co-Founder",
        imageSrc = "/avatars/peter-hoogeveen.jpg",
        email = "peter@zenmo.com",
        linkedIn = "https://www.linkedin.com/in/hogeveenpeter/",
        enBio = """
            Peter studied physics and in 2024 got a PhD for his research into transition models for energy and mobility 
            systems.
        """.trimIndent(),
        nlBio = """
            Peter studeerde technische natuurkunde en promoveerde in 2024 op zijn onderzoek naar transitiemodellen voor 
            energie- en mobiliteitssystemen.
        """.trimIndent(),
    ),
    NAUD_LOOMANS(
        memberName = "Naud Loomans",
        enRole = "Modeller, marketing & website",
        nlRole = "Modeller, marketing & website",
        imageSrc = "/avatars/Loomans_Naud.jpg",
        email = "naud@zenmo.com",
        linkedIn = "https://www.linkedin.com/in/naud-loomans/",
        enBio = """
            Naud joined Zenmo after successfully completing his master's internship with us. Besides his work at
            Zenmo he is pursuing a PhD degree with his research into sector coupling.
        """.trimIndent(),
        nlBio = """
            Naud is na een succesvolle afstudeerstage bij Zenmo in dienst gekomen en doet daarnaast
            promotieonderzoek naar sector coupling in de energiesector.
        """.trimIndent(),
    ),
    MAARTEN(
        memberName = "Maarten Steinbuch",
        enRole = "Smart mobility professor & co-founder",
        nlRole = "Professor slimme mobiliteit & co-founder",
        imageSrc = "/avatars/Maarten-Steinbuch.jpg",
        linkedIn = "https://www.linkedin.com/in/steinbuch/",
        email = "m.steinbuch@tue.nl",
        enBio = """
            Maarten is distinguished university professor at Eindhoven University of Technology (TU/e) and knows 
            everything about smart electric vehicles and robotics.
        """.trimIndent(),
        nlBio = """
            Maarten is distinguished university professor aan de universiteit van Eindhoven (TU/e) en weet alles van 
            slimme elektrisch auto's en trucks en robotica.
        """.trimIndent(),
    ),
    PETER_MOLENGRAAF(
        memberName = "Peter Molengraaf",
        enRole = "Energy transition expert & co-founder",
        nlRole = "Energietransitie-expert & co-founder",
        imageSrc = "/avatars/Peter_molengraaf.jpg",
        email = "",
        enBio = """
            As CEO of grid operator Alliander, Peter was instrumental in the inception of many renewable energy
            initiatives. He is currently chairman of the Supervisory Board at Invest-NL.
        """.trimIndent(),
        nlBio = """
            Peter stond ooit als CEO van netbeheerder Alliander aan de wieg van vele duurzame initiatieven in
            Nederland en is nu voorzitter van de RvC bij Invest-NL.
        """.trimIndent(),
    ),
    IRIS(
        memberName = "Iris Hoekstra",
        enRole = "Assistant",
        nlRole = "Assistent",
        imageSrc = "/avatars/Iris-Hoekstra.jpg",
        email = "iris@zenmo.com",
        linkedIn = "https://www.linkedin.com/in/irishoekstra/",
        enBio = "Iris provides administrative support for Zenmo and is Auke's personal assistant.",
        nlBio = "Iris is het administratieve geweten van Zenmo en de persoonlijk assistent van Auke.",
    ),
    ATE(
        memberName = "Ate Hempenius",
        enRole = "Modeller",
        nlRole = "Modelleur",
        imageSrc = "/avatars/Ate.png",
        email = "ate@zenmo.com",
        linkedIn = "https://www.linkedin.com/in/ate-hempenius-90b493184/",
        enBio = """
            Ate joined Zenmo after successfully completing his master's internship with us. He knows everything
            about our LUX energy twin.
        """.trimIndent(),
        nlBio = """
            Ate is na een succesvolle afstudeerstage bij Zenmo in dienst gekomen en weet alles van onze
            LUX energy twin.
        """.trimIndent(),
    ),
    LUC(
        memberName = "Luc-Sol",
        enRole = "Modeller",
        nlRole = "Modelleur",
        imageSrc = "/avatars/Luc-Sol.jpg",
        email = "luc@zenmo.com",
        linkedIn = "https://www.linkedin.com/in/lucsol/",
        enBio = """
            Luc is a mathematician and knows everything about our LUX energy twin. Besides that, he is an amazing
            chess player.
        """.trimIndent(),
        nlBio = """
            Luc is wiskundige en weet alles van onze LUX energy twin. Daarnaast kan hij verbazend goed schaken.
        """.trimIndent(),
    ),
    BAS(
        memberName = "Bas Dekker",
        enRole = "Modeller",
        nlRole = "Modelleur",
        imageSrc = "/avatars/Bas.jpg",
        email = "bas@zenmo.com",
        linkedIn = "https://www.linkedin.com/in/bas-dekker-a628101bb/",
        enBio = """
            Bas joined Zenmo after successfully completing his master's internship with us. He knows everything
            about our LUX energy twin.
        """.trimIndent(),
        nlBio = """
            Bas is na een succesvolle afstudeerstage bij Zenmo in dienst gekomen en weet alles van onze
            LUX energy twin.
        """.trimIndent(),
    ),
    ERIK(
        memberName = "Erik van Velzen",
        enRole = "Software Developer",
        nlRole = "Softwareontwikkelaar",
        imageSrc = "/avatars/Erik.jpg",
        email = "erik@zenmo.com",
        linkedIn = "https://www.linkedin.com/in/erik-van-velzen-130ab179/",
        enBio = """
            Erik makes sure all our systems run smoothly and connects our simulations to external systems and data
            sources. He also takes care of our web development with Kofi.
        """.trimIndent(),
        nlBio = """
            Erik koppelt onze simulaties aan externe systemen en databronnen. Ook zorgt hij samen met Vincent Kofi
            voor ons web development.
        """.trimIndent(),
    ),
    KOFI(
        memberName = "Vincent Kofi K.",
        enRole = "Software Developer",
        nlRole = "Softwareontwikkelaar",
        imageSrc = "/avatars/kofi.jpg",
        email = "kofi@zenmo.com",
        twitter = "k_o_f_i",
        linkedIn = "https://www.linkedin.com/in/kofi-k-516778196/",
        enBio = """
            Kofi is our web development wizard. He lives in Ghana but digitally he is always close to the team.
        """.trimIndent(),
        nlBio = """
            Kofi is onze web development wizard. He woont in Ghana maar digitaal is hij altijd dicht bij het team.
        """.trimIndent(),
    ),
}