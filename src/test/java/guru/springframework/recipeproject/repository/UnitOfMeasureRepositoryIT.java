package guru.springframework.recipeproject.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.recipeproject.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void findByDescription() {
        Optional<UnitOfMeasure> unit = this.unitOfMeasureRepository.findByDescription("Teaspoon");

        assertTrue(unit.isPresent());
        assertEquals("Teaspoon", unit.get().getDescription());
    }
}