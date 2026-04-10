import * as fs from "node:fs";
import { basename, extname, join } from "node:path";
import { styleText } from "node:util";

for await (
    const entry of walk("decompiled/in.etuwa", [".java"], {
        followSymlinks: true,
        ignoreDotFiles: true,
    })
) {
    if (entry.includes("$")) {
        const contents = await fs.promises.readFile(entry, "utf-8");
        if (contents.trim().length === 0 || entry.includes("$sam$")) {
            console.log(styleText("red", entry));
            await fs.promises.rm(entry);
        } else {
            console.log(entry);
        }
    }
}

export async function* walk(
    path: string,
    extensions: string[],
    options: {
        ignoreDotFiles: boolean;
        followSymlinks: boolean;
    },
): AsyncGenerator<string> {
    const filename = basename(path);
    const stat = await fs.promises.lstat(path);

    if (stat.isFile() && extensions.includes(extname(filename))) {
        yield path;
    } else if (stat.isDirectory()) {
        const dir = await fs.promises.opendir(path);
        for await (const dirent of dir) {
            const resolved = join(path, dirent.name);
            if (dirent.name.startsWith(".") && options.ignoreDotFiles) continue;
            yield* walk(resolved, extensions, options);
        }
    } else if (stat.isSymbolicLink() && options.followSymlinks) {
        const realpath = await fs.promises.realpath(path);
        yield* walk(realpath, extensions, options);
    } else {
        // ignore
    }
}
