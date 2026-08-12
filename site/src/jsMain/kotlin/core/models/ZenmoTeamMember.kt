package energy.lux.frontend.core.models

enum class ZenmoTeamMember(
    val memberName: String,
    val enTitle: String,
    val nlTitle: String,
    val image: String,
    val email: String,
    val linkedIn: String = "",
    val twitter: String = "",
    val enBio: String = """
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore 
        magna aliqua.
    """.trimIndent(),
    val nlBio: String = """
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore 
        magna aliqua.
    """.trimIndent(),
) {
    AUKE(
        memberName = "Auke Hoekstra",
        enTitle = "Director & founder",
        nlTitle = "Directeur & oprichter",
        image = "/avatars/Auke_Hoekstra.jpg",
        email = "auke@zenmo.com",
    ),
    PETER_HOGEVEEN(
        memberName = "Peter Hogeveen",
        enTitle = "Technical Director & Co-Founder",
        nlTitle = "Technisch Directeur & Co-Founder",
        image = "/avatars/peter-hoogeveen.jpg",
        email = "peter@zenmo.com",
    ),
    NAUD_LOOMANS(
        memberName = "Naud Loomans",
        enTitle = "Modeller, marketing & website",
        nlTitle = "Modeller, marketing & website",
        image = "/avatars/Loomans_Naud.jpg",
        email = "naud@zenmo.com",
    ),
    MAARTEN(
        memberName = "Maarten Steinbuch",
        enTitle = "Smart mobility professor & co-founder",
        nlTitle = "Professor slimme mobiliteit & co-founder",
        image = "/avatars/Maarten-Steinbuch.jpg",
        email = "",
    ),
    PETER_MOLENGRAAF(
        memberName = "Peter Molengraaf",
        enTitle = "Energy transition expert & co-founder",
        nlTitle = "Energietransitie-expert & co-founder",
        image = "/avatars/Peter_molengraaf.jpg",
        email = "",
    ),
    IRIS(
        memberName = "Iris Hoekstra",
        enTitle = "Assistant",
        nlTitle = "Assistent",
        image = "/avatars/Iris-Hoekstra.jpg",
        email = "iris@zenmo.com",
    ),
    ATE(
        memberName = "Ate Hempenius",
        enTitle = "Modeller",
        nlTitle = "Modelleur",
        image = "/avatars/Ate.png",
        email = "ate@zenmo.com",
    ),
    LUC(
        memberName = "Luc-Sol",
        enTitle = "Modeller",
        nlTitle = "Modelleur",
        image = "/avatars/Luc-Sol.jpg",
        email = "luc@zenmo.com",
    ),
    BAS(
        memberName = "Bas Dekker",
        enTitle = "Modeller",
        nlTitle = "Modelleur",
        image = "",
        email = "bas@zenmo.com",
    ),
    ERIK(
        memberName = "Erik van Velzen",
        enTitle = "Software Developer",
        nlTitle = "Software ontwikkelaar",
        image = "/avatars/Erik.jpg",
        email = "erik@zenmo.com",
    ),
    KOFI(
        memberName = "Vincent Kofi K.",
        enTitle = "Software Developer",
        nlTitle = "Software ontwikkelaar",
        image = "/avatars/kofi.jpg",
        email = "kofi@zenmo.com",
    ),
}