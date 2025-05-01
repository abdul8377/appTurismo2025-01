package pe.edu.upeu.appturismo202501.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import pe.edu.upeu.appturismo202501.data.remote.RestLoginUsuario;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class LoginUserRespositoryImp_Factory implements Factory<LoginUserRespositoryImp> {
  private final Provider<RestLoginUsuario> restLoginUsuarioProvider;

  public LoginUserRespositoryImp_Factory(Provider<RestLoginUsuario> restLoginUsuarioProvider) {
    this.restLoginUsuarioProvider = restLoginUsuarioProvider;
  }

  @Override
  public LoginUserRespositoryImp get() {
    return newInstance(restLoginUsuarioProvider.get());
  }

  public static LoginUserRespositoryImp_Factory create(
      Provider<RestLoginUsuario> restLoginUsuarioProvider) {
    return new LoginUserRespositoryImp_Factory(restLoginUsuarioProvider);
  }

  public static LoginUserRespositoryImp newInstance(RestLoginUsuario restLoginUsuario) {
    return new LoginUserRespositoryImp(restLoginUsuario);
  }
}
