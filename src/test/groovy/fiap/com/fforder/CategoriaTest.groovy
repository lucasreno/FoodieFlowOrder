package fiap.com.fforder

import fiap.com.fforder.entity.categoria.exception.CategoriaAlreadyExistsException
import fiap.com.fforder.entity.categoria.exception.CategoriaNotFoundException
import fiap.com.fforder.entity.categoria.model.Categoria
import fiap.com.fforder.usecase.categoria.CreateCategoriaUseCase
import fiap.com.fforder.usecase.categoria.DeleteCategoriaUseCase
import fiap.com.fforder.usecase.categoria.FindAllCategoriaUseCase
import fiap.com.fforder.usecase.categoria.FindCategoriaByNomeUseCase
import fiap.com.fforder.usecase.categoria.FindCategoriaUseCase
import fiap.com.fforder.usecase.categoria.UpdateCategoriaUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class CategoriaTest extends Specification {

    @Autowired
    CreateCategoriaUseCase createCategoriaUseCase

    @Autowired
    UpdateCategoriaUseCase updateCategoriaUseCase

    @Autowired
    DeleteCategoriaUseCase deleteCategoriaUseCase

    @Autowired
    FindAllCategoriaUseCase findAllCategoriaUseCase

    @Autowired
    FindCategoriaByNomeUseCase findCategoriaByNomeUseCase

    @Autowired
    FindCategoriaUseCase findCategoriaUseCase

    def "Create Categoria"() {
        when:
        Categoria categoria = createCategoriaUseCase.execute("Acompanhamentos")

        then:
        categoria.nome == "Acompanhamentos"
        categoria.id != null
    }

    def "Create Categoria with same name"() {
        when:
        createCategoriaUseCase.execute("Lanches")
        createCategoriaUseCase.execute("Lanches")

        then:
        thrown CategoriaAlreadyExistsException
    }

    def "Not found Categoria"() {
        when:
        updateCategoriaUseCase.execute(9999, "Bebidas")

        then:
        thrown CategoriaNotFoundException
    }

    def "Update Categoria"() {
        when:
        Categoria categoria = createCategoriaUseCase.execute("Bebidas")

        then:
        Categoria categoriaUpdated = updateCategoriaUseCase.execute(categoria.id, "Bebidas Alcoólicas")

        then:
        categoriaUpdated.nome == "Bebidas Alcoólicas"
        categoriaUpdated.id == categoria.id
    }

    def "Delete Categoria"() {
        when:
        Categoria categoria = createCategoriaUseCase.execute("Entradas")

        then:
        Categoria categoriaDeleted = deleteCategoriaUseCase.execute(categoria.id)

        then:
        categoriaDeleted.nome == "Entradas"
        categoriaDeleted.id == categoria.id
    }

    def "Delete Categoria not found"() {
        when:
        deleteCategoriaUseCase.execute(9999)

        then:
        thrown CategoriaNotFoundException
    }

    def "Find All Categoria"() {
        when:
        createCategoriaUseCase.execute("Sobremesas")

        then:
        List<Categoria> categorias = findAllCategoriaUseCase.execute()

        then:
        categorias.size() > 0
        categorias.find { it.nome == "Sobremesas" } != null
    }

    def "Find Categoria by Nome"() {
        when:
        createCategoriaUseCase.execute("Pratos Principais")

        then:
        List<Categoria> categorias = findCategoriaByNomeUseCase.execute("Pratos Principais")

        then:
        categorias.size() == 1
        categorias.find { it.nome == "Pratos Principais" } != null
    }

    def "Find Categoria not found by Nome"() {
        when:
        List<Categoria> categorias = findCategoriaByNomeUseCase.execute("Não existe")

        then:
        thrown CategoriaNotFoundException
    }

    def "Find Categoria by Id"() {
        when:
        Categoria categoria = createCategoriaUseCase.execute("Saladas")

        then:
        Categoria categoriaFound = findCategoriaUseCase.execute(categoria.id)

        then:
        categoriaFound.nome == "Saladas"
        categoriaFound.id == categoria.id
    }

    def "Find Categoria not found by Id"() {
        when:
        findCategoriaUseCase.execute(9999)

        then:
        thrown CategoriaNotFoundException
    }

}
