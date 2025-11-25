import dev.slne.surf.surfapi.gradle.util.withSurfApiBukkit

plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}
group = "de.hiorcraft.nex"
version = findProperty("version") as String

surfPaperPluginApi {
    mainClass("de.hiorcraft.nex.nextools.BukkitMain")
    generateLibraryLoader(false)
    authors.add("HiorCraft")

    runServer {
        withSurfApiBukkit()
    }
}

kotlin {
    jvmToolchain(24)
}
