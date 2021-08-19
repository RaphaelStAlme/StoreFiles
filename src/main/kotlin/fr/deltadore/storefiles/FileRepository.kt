package fr.deltadore.storefiles;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FileRepository : JpaRepository<File, Long> {
}