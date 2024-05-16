package fiap.com.fforder.infrastructure.initializer

import fiap.com.fforder.usecase.categoria.CreateCategoriaUseCase

class CategoriaInitializer {

    private CreateCategoriaUseCase createCategoriaUseCase

    CategoriaInitializer(CreateCategoriaUseCase createCategoriaUseCase) {
        this.createCategoriaUseCase = createCategoriaUseCase
        this.init()
    }

    void init() {
        println "Inicializando categorias..."
        List<String> CATEGORIAS = ['Lanche', 'Acompanhamento', 'Bebida', 'Sobremesa']
        CATEGORIAS.each {
            try {
                createCategoriaUseCase.execute(it)
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}
