package zieunx.module.annotation.processor;

import zieunx.module.annotation.CharlesIntent;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.HashSet;
import java.util.Set;

public class CharlesProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println("애노테이션 프로세싱!!");//프로세싱이 되는지 확인하기 위한 로그 확인용입니다.
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new HashSet<String>(){
            {
                add(CharlesIntent.class.getCanonicalName());// 어떤 애노테이션을 처리할 지 Set에 추가합니다.
            }
        };
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();//지원되는 소스 버전을 리턴합니다.
    }
}
