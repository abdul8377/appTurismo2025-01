package pe.edu.upeu.appturismo202501.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
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
public final class DataSourceModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final DataSourceModule module;

  private final Provider<String> baseUrlProvider;

  public DataSourceModule_ProvideRetrofitFactory(DataSourceModule module,
      Provider<String> baseUrlProvider) {
    this.module = module;
    this.baseUrlProvider = baseUrlProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module, baseUrlProvider.get());
  }

  public static DataSourceModule_ProvideRetrofitFactory create(DataSourceModule module,
      Provider<String> baseUrlProvider) {
    return new DataSourceModule_ProvideRetrofitFactory(module, baseUrlProvider);
  }

  public static Retrofit provideRetrofit(DataSourceModule instance, String baseUrl) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofit(baseUrl));
  }
}
