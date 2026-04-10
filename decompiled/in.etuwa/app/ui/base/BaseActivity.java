package in.etuwa.app.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;

/* JADX INFO: compiled from: BaseActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void hideProgress();

    protected abstract void setUp();

    protected abstract void showProgress();
}