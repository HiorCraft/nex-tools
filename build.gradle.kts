plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin") version "1.21.11+"
}
surfPaperPluginApi {
    mainClass("de.hiorcraft.nex.nextools.BukkitMain")
    generateLibraryLoader(false)

    authors.add("Hiorcraft")
}

version = findProperty("version") as String
group = "de.hiorcraft.nex.nextools"