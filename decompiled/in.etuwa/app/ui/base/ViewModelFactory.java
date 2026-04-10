package in.etuwa.app.ui.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import in.etuwa.app.data.network.ApiHelper;
import in.etuwa.app.data.repository.LoginRepository;
import in.etuwa.app.ui.login.LoginViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewModelFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewModelFactory implements ViewModelProvider.Factory {
    private final ApiHelper apiHelper;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
    }

    public ViewModelFactory(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return new LoginViewModel(new LoginRepository(this.apiHelper));
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}