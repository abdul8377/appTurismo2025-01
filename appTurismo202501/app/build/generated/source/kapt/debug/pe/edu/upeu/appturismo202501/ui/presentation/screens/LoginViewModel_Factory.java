package pe.edu.upeu.appturismo202501.ui.presentation.screens;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import pe.edu.upeu.appturismo202501.repository.LoginUserRepository;

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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<LoginUserRepository> loginRepoProvider;

  public LoginViewModel_Factory(Provider<LoginUserRepository> loginRepoProvider) {
    this.loginRepoProvider = loginRepoProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(loginRepoProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<LoginUserRepository> loginRepoProvider) {
    return new LoginViewModel_Factory(loginRepoProvider);
  }

  public static LoginViewModel newInstance(LoginUserRepository loginRepo) {
    return new LoginViewModel(loginRepo);
  }
}
