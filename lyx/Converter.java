package lyx;

public interface Converter<F, T> {
	T convert(F from);
}
