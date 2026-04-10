package in.etuwa.app.ui.chat;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.chat.subjects.ChatResponse;
import in.etuwa.app.data.repository.ChatRepository;
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

/* compiled from: ChatViewModel.kt */
/* loaded from: classes4.dex */
public final class ChatViewModel extends ViewModel {
    private final ChatRepository chatRepository;
    private MutableLiveData<Resource<ChatResponse>> chatResponse;
    private final CompositeDisposable compositeDisposable;

    public ChatViewModel(ChatRepository chatRepository) {
        Intrinsics.checkNotNullParameter(chatRepository, "chatRepository");
        this.chatRepository = chatRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.chatResponse = new MutableLiveData<>();
        getChat();
    }

    public final void getChat() {
        this.chatResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ChatResponse> observeOn = this.chatRepository.getChatSubjectsApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ChatResponse, Unit> function1 = new Function1<ChatResponse, Unit>() { // from class: in.etuwa.app.ui.chat.ChatViewModel$getChat$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatResponse chatResponse) {
                invoke2(chatResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatResponse chatResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ChatViewModel.this.chatResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(chatResponse));
            }
        };
        Consumer<? super ChatResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.chat.ChatViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatViewModel.getChat$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.chat.ChatViewModel$getChat$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ChatViewModel.this.chatResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
                System.out.println((Object) ("========================= " + th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.chat.ChatViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatViewModel.getChat$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChat$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getChat$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ChatResponse>> getResponse() {
        return this.chatResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}