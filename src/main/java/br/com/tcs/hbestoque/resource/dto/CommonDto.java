package br.com.tcs.hbestoque.resource.dto;

import br.com.tcs.hbestoque.model.commons.CategoriaProdutoEnum;
import br.com.tcs.hbestoque.model.commons.TipoEmbalagemEnum;
import br.com.tcs.hbestoque.model.commons.VolumeEnum;

public class CommonDto {
	
	public static VolumeEnum parseVolume(Integer volume) {
		VolumeEnum[]volumes = VolumeEnum.values();
		VolumeEnum vselect  = null;
		
		for(VolumeEnum v : volumes) {
			if(v.ordinal() == volume) {
				vselect = v;
				break;
			}
		}
		return vselect;
	}
	
	public static CategoriaProdutoEnum parseCategoria(Integer categoria) {
		CategoriaProdutoEnum[]categorias = CategoriaProdutoEnum.values();
		CategoriaProdutoEnum cselect  = null;
		
		for(CategoriaProdutoEnum c : categorias) {
			if(c.ordinal() == categoria) {
				cselect = c;
				break;
			}
		}
		return cselect;
	}

	public static TipoEmbalagemEnum parseTipoEmbalabem(Integer embalagem) {
		TipoEmbalagemEnum[]embalagens = TipoEmbalagemEnum.values();
		TipoEmbalagemEnum eselect  = null;
		
		for(TipoEmbalagemEnum e : embalagens) {
			if(e.ordinal() == embalagem) {
				eselect = e;
				break;
			}
		}
		return eselect;
	}
	
}
