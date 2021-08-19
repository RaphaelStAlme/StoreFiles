package fr.deltadore.storefiles

import org.springframework.core.io.FileSystemResource
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun save(file: MultipartFile) : File
    fun downloadFile(id : Long): FileSystemResource
}