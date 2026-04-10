package in.etuwa.app.ui.programoutcome;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.programoutcome.ProgramOutcomeResponse;
import in.etuwa.app.data.repository.ProgramOutcomeRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgramOutcomeViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ProgramOutcomeViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private boolean isDataLoaded;
    private MutableLiveData<Resource<ProgramOutcomeResponse>> outcomeResponse;
    private final ProgramOutcomeRepository programOutcomeRepository;

    public ProgramOutcomeViewModel(ProgramOutcomeRepository programOutcomeRepository) {
        Intrinsics.checkNotNullParameter(programOutcomeRepository, "programOutcomeRepository");
        this.programOutcomeRepository = programOutcomeRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.outcomeResponse = new MutableLiveData<>();
        loadDataIfNeeded();
    }

    public final void loadDataIfNeeded() {
        if (this.isDataLoaded) {
            return;
        }
        this.isDataLoaded = true;
        getOutcomes();
    }

    public final void getOutcomes() {
        this.outcomeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ProgramOutcomeResponse> singleObserveOn = this.programOutcomeRepository.getProgramOutcomeApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ProgramOutcomeResponse, Unit> function1 = new Function1<ProgramOutcomeResponse, Unit>() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeViewModel.getOutcomes.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProgramOutcomeResponse programOutcomeResponse) {
                invoke2(programOutcomeResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProgramOutcomeResponse programOutcomeResponse) {
                ProgramOutcomeViewModel.this.outcomeResponse.postValue(Resource.INSTANCE.success(programOutcomeResponse));
            }
        };
        Consumer<? super ProgramOutcomeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ProgramOutcomeViewModel.getOutcomes$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeViewModel.getOutcomes.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ProgramOutcomeViewModel.this.outcomeResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.programoutcome.ProgramOutcomeViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ProgramOutcomeViewModel.getOutcomes$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOutcomes$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOutcomes$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ProgramOutcomeResponse>> getResponse() {
        return this.outcomeResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}