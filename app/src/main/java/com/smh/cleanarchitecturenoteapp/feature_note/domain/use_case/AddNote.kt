package com.smh.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.smh.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.smh.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.smh.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank())
            throw InvalidNoteException("the title of note can't be empty")
        if (note.content.isBlank())
            throw InvalidNoteException("the content of note can't be empty")
        repository.addNote(note)
    }

}