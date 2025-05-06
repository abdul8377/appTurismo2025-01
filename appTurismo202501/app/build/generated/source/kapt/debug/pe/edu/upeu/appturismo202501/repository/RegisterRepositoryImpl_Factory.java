package pe.edu.upeu.appturismo202501.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import pe.edu.upeu.appturismo202501.data.remote.RestRegister;

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
public final class RegisterRepositoryImpl_Factory implements Factory<RegisterRepositoryImpl> {
  private final Provider<RestRegister> restRegisterProvider;

  public RegisterRepositoryImpl_Factory(Provider<RestRegister> restRegisterProvider) {
    this.restRegisterProvider = restRegisterProvider;
  }

  @Override
  public RegisterRepositoryImpl get() {
    return newInstance(restRegisterProvider.get());
  }

  public static RegisterRepositoryImpl_Factory create(Provider<RestRegister> restRegisterProvider) {
    return new RegisterRepositoryImpl_Factory(restRegisterProvider);
  }

  public static RegisterRepositoryImpl newInstance(RestRegister restRegister) {
    return new RegisterRepositoryImpl(restRegister);
  }
}
