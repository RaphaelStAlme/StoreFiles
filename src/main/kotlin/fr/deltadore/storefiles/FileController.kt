package fr.deltadore.storefiles

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/")
class FileController(
    @Autowired private val repository: FileRepository,
    @Autowired private val fileService: FileService
) {

    @GetMapping("/file/{id}", MediaType.IMAGE_JPEG_VALUE)
    fun getFileById(@PathVariable id: Long): FileSystemResource {
        return fileService.downloadFile(id)
    }

    @PostMapping("/file")
    fun uploadFile(@RequestBody file: MultipartFile): File {
        val dbFile = fileService.save(file)
        return repository.save(dbFile)
    }
}