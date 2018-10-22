package api.daos.memory;

import api.daos.GenericDao;

import java.util.*;

public abstract class GenericDaoMemory<T> implements GenericDao<T, String> {

    private Map<String, T> map;

    private int id;

    GenericDaoMemory() {
        this.map = new HashMap<>();
        this.id = 1;
    }

    @Override
    public void save(T entity) {
        String idString = this.getId(entity);
        if (idString == null) {
            idString = String.valueOf(this.id++);
            this.setId(entity, idString);
        }
        this.map.put(idString, entity);
    }

    @Override
    public Optional<T> read(String id) {
        T entity = map.get(id);
        return Optional.ofNullable(entity);
    }

    @Override
    public void deleteById(String id) {
    }

    @Override
    public List<T> findAll() {
        ArrayList<T> list = new ArrayList<>(map.values());
        return list;
    }

    public abstract String getId(T entity);

    public abstract void setId(T entity, String id);

}
