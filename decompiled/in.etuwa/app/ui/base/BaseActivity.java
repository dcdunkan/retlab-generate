package in.etuwa.app.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;

/* compiled from: BaseActivity.kt */
/* loaded from: classes4.dex */
public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void hideProgress();

    protected abstract void setUp();

    protected abstract void showProgress();
}