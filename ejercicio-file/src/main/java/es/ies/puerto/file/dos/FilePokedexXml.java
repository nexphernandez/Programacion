package es.ies.puerto.file.dos;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
import java.util.List;

public class FilePokedexXml extends XmlOperationsPok{

    List<Pokemon> pokemons = xmlPokRead();

    /**
     * Funcion que lee los pokemons que se encuentran en el fichero
     * @return lista de pokemons
     */
    public List<Pokemon> obtenerPokemons() {
        return pokemons;
    }

    /**
     * Funcion que obtiene un pokemon del fichero
     * @param pokemon a buscar
     * @return pokemon con todos los atributos
     */
    public Pokemon obtenerPokemon(Pokemon pokemon) {
        if (pokemon == null) {
            return null;
        }
        for (Pokemon pokemonBuscar : pokemons) {
            if (pokemonBuscar.equals(pokemon)) {
                return pokemonBuscar;
            }
        }
        return null;
    }

    /**
     * Funcion que agregan pokemons al fichero
     * @param pokemon a aniadir
     */
    public void addPokemon(Pokemon pokemon) {
        if (pokemon == null) {
            return;
        }
        pokemons.add(pokemon);
        xmlPokWrite(pokemons);

    }

    /**
     * Funcion que borran pokemos del fichero
     * @param pokemon a eliminar
     */
    public void deletePokemon(Pokemon pokemon) {
        if (pokemon == null) {
            return;
        }
        pokemons.remove(pokemon);
        xmlPokWrite(pokemons);
    }

    /**
     * Funcion que actualiza un pokemon del fichero
     * @param pokemon con los datos a actualizar
     */
    public void updatePokemon(Pokemon pokemon) {
        if (pokemon == null) {
            return;
        }
        if (pokemons.removeIf(p -> p.getId().equals(pokemon.getId()))) {
            pokemons.add(pokemon);
        }
        xmlPokWrite(pokemons);

    }

}
