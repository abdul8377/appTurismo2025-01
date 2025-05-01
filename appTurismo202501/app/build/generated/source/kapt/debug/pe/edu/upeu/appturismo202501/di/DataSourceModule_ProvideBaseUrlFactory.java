package pe.edu.upeu.appturismo202501.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class DataSourceModule_ProvideBaseUrlFactory implements Factory<String> {
  private final DataSourceModule module;

  public DataSourceModule_ProvideBaseUrlFactory(DataSourceModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return provideBaseUrl(module);
  }

  public static DataSourceModule_ProvideBaseUrlFactory create(DataSourceModule module) {
    return new DataSourceModule_ProvideBaseUrlFactory(module);
  }

  public static String provideBaseUrl(DataSourceModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideBaseUrl());
  }
}
