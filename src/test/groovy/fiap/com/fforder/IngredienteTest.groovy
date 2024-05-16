package fiap.com.fforder

import fiap.com.fforder.entity.ingrediente.exception.IngredienteAlreadyExistsException
import fiap.com.fforder.entity.ingrediente.exception.IngredienteNotFoundException
import fiap.com.fforder.entity.ingrediente.model.Ingrediente
import fiap.com.fforder.usecase.ingrediente.CreateIngredienteUseCase
import fiap.com.fforder.usecase.ingrediente.DeleteIngredienteUseCase
import fiap.com.fforder.usecase.ingrediente.FindAllIngredienteUseCase
import fiap.com.fforder.usecase.ingrediente.FindIngredienteByNomeUseCase
import fiap.com.fforder.usecase.ingrediente.FindIngredienteUseCase
import fiap.com.fforder.usecase.ingrediente.UpdateIngredienteUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class IngredienteTest extends Specification {
    @Autowired
    CreateIngredienteUseCase createIngredienteUseCase

    @Autowired
    DeleteIngredienteUseCase deleteIngredienteUseCase

    @Autowired
    FindAllIngredienteUseCase findAllIngredienteUseCase

    @Autowired
    FindIngredienteByNomeUseCase findIngredienteByNomeUseCase

    @Autowired
    FindIngredienteUseCase findIngredienteUseCase

    @Autowired
    UpdateIngredienteUseCase updateIngredienteUseCase

    def "Create Ingrediente with same nome"() {
        given:
        createIngredienteUseCase.execute("Ingrediente 1")
        when:
        createIngredienteUseCase.execute("Ingrediente 1")
        then:
        thrown IngredienteAlreadyExistsException
    }

    def "Delete Ingrediente"() {
        given:
        Ingrediente ingrediente = createIngredienteUseCase.execute("Ingrediente 2")
        when:
        deleteIngredienteUseCase.execute(ingrediente.id)
        then:
        findAllIngredienteUseCase.execute().find { it.id == ingrediente.id } == null
    }

    def "Delete Ingrediente not found"() {
        when:
        deleteIngredienteUseCase.execute(0)
        then:
        thrown IngredienteNotFoundException
    }

    def "Find All Ingrediente"() {
        given:
        createIngredienteUseCase.execute("Ingrediente 3")
        createIngredienteUseCase.execute("Ingrediente 4")
        when:
        List<Ingrediente> ingredientes = findAllIngredienteUseCase.execute()
        then:
        ingredientes.size() >= 2
    }

    def "Find Ingrediente by Nome"() {
        given:
        createIngredienteUseCase.execute("Ingrediente 5")
        when:
        Ingrediente ingrediente = findIngredienteByNomeUseCase.execute("Ingrediente 5").get(0)
        then:
        ingrediente.nome == "Ingrediente 5"
    }

    def "Find Ingrediente by Nome not found"() {
        when:
        findIngredienteByNomeUseCase.execute("Ingrediente 6")
        then:
        thrown IngredienteNotFoundException
    }

    def "Find Ingrediente by Id"() {
        given:
        Ingrediente ingrediente = createIngredienteUseCase.execute("Ingrediente 7")
        when:
        Ingrediente ingredienteEncontrado = findIngredienteUseCase.execute(ingrediente.id)
        then:
        ingredienteEncontrado.id == ingrediente.id
    }

    def "Find Ingrediente by Id not found"() {
        when:
        findIngredienteUseCase.execute(0)
        then:
        thrown IngredienteNotFoundException
    }

    def "Update Ingrediente"() {
        given:
        Ingrediente ingrediente = createIngredienteUseCase.execute("Ingrediente 8")
        when:
        Ingrediente ingredienteAtualizado = updateIngredienteUseCase.execute(ingrediente.id, "Ingrediente 9")
        then:
        ingredienteAtualizado.nome == "Ingrediente 9"
    }

    def "Update Ingrediente not found"() {
        when:
        updateIngredienteUseCase.execute(0, "Ingrediente 10")
        then:
        thrown IngredienteNotFoundException
    }


}
