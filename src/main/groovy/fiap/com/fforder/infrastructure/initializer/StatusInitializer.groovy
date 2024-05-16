package fiap.com.fforder.infrastructure.initializer

import fiap.com.fforder.usecase.status.CreateStatusUseCase

class StatusInitializer {
    private CreateStatusUseCase createStatusUseCase

    StatusInitializer(CreateStatusUseCase createStatusUseCase) {
        this.createStatusUseCase = createStatusUseCase
        this.init()
    }

    void init() {
        println "Inicializando status..."
        List<String> STATUS = ['Recebido', 'Em preparação', 'Pronto', 'Finalizado']
        STATUS.each {
            try {
                createStatusUseCase.execute(it)
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}
