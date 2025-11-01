package in.etuwa.app.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;

/* compiled from: BaseActivity.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H$J\b\u0010\u0005\u001a\u00020\u0004H$J\b\u0010\u0006\u001a\u00020\u0004H$¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "hideProgress", "", "setUp", "showProgress", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void hideProgress();

    protected abstract void setUp();

    protected abstract void showProgress();
}