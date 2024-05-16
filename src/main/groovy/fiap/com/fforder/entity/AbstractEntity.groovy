package fiap.com.fforder.entity

abstract class AbstractEntity<ID extends Serializable> implements Serializable {
    private ID id

    ID getId() {
        return id
    }

    void setId(ID id) {
        this.id = id
    }

    @Override
    int hashCode() {
        return Objects.hashCode(id)
    }

    @Override
    String toString() {
        return "id=" + id
    }
}
