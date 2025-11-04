import dev.slne.surf.surfapi.gradle.util.withSurfApiBukkit

plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}

dependencies {
    api("dev.slne.surf:surf-database:2.2.1-SNAPSHOT")
}
group = "de.hiorcraft.nex"
version = "1.21.10-1.2.0"

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
