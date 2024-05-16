package fiap.com.fforder.infrastructure.initializer

import fiap.com.fforder.usecase.ingrediente.CreateIngredienteUseCase

class IngredienteInitializer {
    private CreateIngredienteUseCase createIngredienteUseCase

    IngredienteInitializer(CreateIngredienteUseCase createIngredienteUseCase) {
        this.createIngredienteUseCase = createIngredienteUseCase
        this.init()
    }

    void init() {
        println "Inicializando ingredientes..."
        List<String> INGREDIENTES = ['Pão', 'Hambúrguer de Carne', 'Queijo', 'Alface', 'Tomate', 'Batata Frita', 'Onion Rings', 'Água', 'Refrigerante', 'Suco de Laranja', 'Sorvete', 'Calda de Chocolate', 'Chantilly', 'Bacon', 'Molho Especial', 'Picles']
        INGREDIENTES.each {
            try {
                createIngredienteUseCase.execute(it)
            } catch (Exception e) {
                // do nothing
            }
        }
    }

}
