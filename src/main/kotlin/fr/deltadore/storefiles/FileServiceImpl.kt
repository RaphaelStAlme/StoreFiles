package fr.deltadore.storefiles

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

@Service
class FileServiceImpl : FileService {
    @Autowired
    private var repository: FileRepository? = null

    private var pathDir: Path = Paths.get("target")

    override fun save(file: MultipartFile): File {
        val dbFile: File
        val newFileName: String = Date().time.toString() + '-' + file.originalFilename
        try {
            Files.copy(file.inputStream, pathDir.resolve(newFileName))
            dbFile = File(newFileName, pathDir.resolve(newFileName).toString())
        } catch (e: Exception) {
            throw RuntimeException("Impossible de sauvegarder le fichier. Error: " + e.message)
        }
        return dbFile
    }

    override fun downloadFile(id: Long): FileSystemResource {
        val file: File = repository?.findById(id)?.orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }!!
        return FileSystemResource(Paths.get(file.path))
    }
}
