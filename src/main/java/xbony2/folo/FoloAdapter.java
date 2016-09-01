package xbony2.folo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.ILanguageAdapter;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.relauncher.Side;
/**
 * do modLanguageAdapter = "xbony2.folo.FoloAdapter"
 * 
 * @author xbony2
 *
 */
public class FoloAdapter implements ILanguageAdapter {

	@Override
	public Object getNewInstance(FMLModContainer container, Class<?> objectClass, ClassLoader classLoader, Method factoryMarkedAnnotation) throws Exception{
		return Class.forName(objectClass.getName() + "$", true, classLoader).getField("MODULE$").get(null);
	}

	@Override
	public boolean supportsStatics(){
		return false;//???
	}

	@Override
	public void setProxy(Field target, Class<?> proxyTarget, Object proxy) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		target.set(null, proxy);
		
	}

	@Override
	public void setInternalProxies(ModContainer mod, Side side, ClassLoader loader){
		// TODO Auto-generated method stub
		
	}
}
