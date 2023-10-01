package mapper;

public interface Mapper<T,K>{
	T mapFrom(K object);
}
