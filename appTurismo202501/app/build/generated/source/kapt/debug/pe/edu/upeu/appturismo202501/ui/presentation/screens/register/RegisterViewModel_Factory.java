package pe.edu.upeu.appturismo202501.ui.presentation.screens.register;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import pe.edu.upeu.appturismo202501.repository.LoginUserRepository;
import pe.edu.upeu.appturismo202501.repository.RegisterRepository;

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
public final class RegisterViewModel_Factory implements Factory<RegisterViewModel> {
  private final Provider<RegisterRepository> registerRepoProvider;

  private final Provider<LoginUserRepository> loginRepoProvider;

  public RegisterViewModel_Factory(Provider<RegisterRepository> registerRepoProvider,
      Provider<LoginUserRepository> loginRepoProvider) {
    this.registerRepoProvider = registerRepoProvider;
    this.loginRepoProvider = loginRepoProvider;
  }

  @Override
  public RegisterViewModel get() {
    return newInstance(registerRepoProvider.get(), loginRepoProvider.get());
  }

  public static RegisterViewModel_Factory create(Provider<RegisterRepository> registerRepoProvider,
      Provider<LoginUserRepository> loginRepoProvider) {
    return new RegisterViewModel_Factory(registerRepoProvider, loginRepoProvider);
  }

  public static RegisterViewModel newInstance(RegisterRepository registerRepo,
      LoginUserRepository loginRepo) {
    return new RegisterViewModel(registerRepo, loginRepo);
  }
}
