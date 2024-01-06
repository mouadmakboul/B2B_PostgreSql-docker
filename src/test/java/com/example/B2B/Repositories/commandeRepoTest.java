package com.example.B2B.Repositories;

import com.example.B2B.Entities.commandeEntity;
import com.example.B2B.Services.CommandeService;
import com.example.B2B.Services.CommandeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommandeRepoTest {

    @Mock
    private commandeRepo repository;

    @InjectMocks
    private CommandeServiceImpl commandeService;

    @Test
    void testFindAll() {
        // Arrange
        List<commandeEntity> mockCommandes = new ArrayList<>();
        mockCommandes.add(new commandeEntity(1,5,7));
        when(repository.findAll()).thenReturn(mockCommandes);

        // Act
        List<commandeEntity> result = commandeService.getAllCommandes();

        // Assert
        assertThat(result).isEqualTo(mockCommandes);
    }

    @Test
    void testFindById() {
        // Arrange
        long id = 1L;
        commandeEntity mockCommande = new commandeEntity(/* initialize with data */);
        when(repository.findById(id)).thenReturn(Optional.of(mockCommande));

        // Act
        Optional<commandeEntity> result = Optional.ofNullable(commandeService.getCommandeById(id));

        // Assert
        assertThat(result).isPresent().contains(mockCommande);
    }

    @Test
    void testSave() {
        // Arrange
        commandeEntity newCommande = new commandeEntity(/* initialize with data */);
        when(repository.save(newCommande)).thenReturn(newCommande);

        // Act
        commandeEntity result = commandeService.createCommande(newCommande);

        // Assert
        assertThat(result).isEqualTo(newCommande);
    }

    @Test
    void testDeleteById() {
        // Arrange
        long id = 1L;

        // Act
        commandeService.deleteCommande(id);

        // Assert
        verify(repository, times(1)).deleteById(id);
    }
}