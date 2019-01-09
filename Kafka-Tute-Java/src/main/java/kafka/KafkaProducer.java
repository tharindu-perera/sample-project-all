package kafka;

import org.springframework.beans.factory.annotation.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class KafkaProducer {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducer.class, args);
     }
}

@Component
class Sender implements CommandLineRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void run(String... args) throws Exception {
        send("edi-ingestion-raw","ISA*04*SW417     *00*          *02*RRDC           *02*CMMXWTNN       *150401*0830*U*00701*001914422*0*P*>\u001C\n" +
                "GS*WB*RRWS*WTNN*20150401*073000*49555*X*007010\u001C\n" +
                "ST*417*495550001\u001C\n" +
                "BX*00*R*11*30685123*UP*L*B*S\u001C\n" +
                "BNX*S**S\u001C\n" +
                "N9*BM*30685123*UP*20150401*072400\u001C\n" +
                "N9*CO*C18447**20150401*072500*CT\u001C\n" +
                "N9*HS*2814.10.0000**20150401*072500*CT\u001C\n" +
                "DTM*168*20150401*072500\u001C\n" +
                "N7*ACFX*220158*156100*N*******RR\u001C\n" +
                "M7*642774\u001C\n" +
                "N8*647861*20150401\u001C\n" +
                "F9*53724*DONALDSONVILLE*LA*****645191\u001C\n" +
                "D9*56918*MARTIN*TN*****438130\u001C\n" +
                "N1*SH*CF INDUSTRIES SALES*C5*0035901630000\u001C\n" +
                "N3*39018 HIGHWAY 3089\u001C\n" +
                "N4*DONALDSONVILLE*LA*70346*US\u001C\n" +
                "N1*CN*TENNESSEE FARMERS COOP*C5*0040364300000\u001C\n" +
                "N3*200 WALDRON RDa\u001C\n" +
                "N4*LAVERGNE*TN*370863221*US\u001C\n" +
                "N1*C1*WEAKLEY FARMERS COOP*C5*0347371710000\u001C\n" +
                "N3*330 NASH ST\u001C\n" +
                "N4*MARTIN*TN*382372245*US\u001C\n" +
                "N1*11*CF INDUSTRIES SALES*C5*0089666320000\u001C\n" +
                "N3*4 PARKWAY NORTH, SUITE 400\u001C\n" +
                "N4*DEERFIELD*IL*60015*US\u001C\n" +
                "BL*RD****DONALDSONVILLE*LA***BATON***UP\u001C\n" +
                "BL*RD****FULTK****MARTIN*TN**WTNN\u001C\n" +
                "BL*RD****BATON****FULTK***CN\u001C\n" +
                "R2*UP*R*BATON\u001C\n" +
                "R2*CN*1*FULTK\u001C\n" +
                "R2*WTNN*2\u001C\n" +
                "LX*1\u001C\n" +
                "L5*1*HAZARDOUS MATERIAL AMMONIA, ANHYDROUS*4904210*T\u001C\n" +
                "L5*1*ID=TERRAIND CAR RAIL, TANK\u001C\n" +
                "L0*1***156100*N***1*CLD\u001C\n" +
                "PI*CT*520747*TP**CN*CN\u001C\n" +
                "PI*CT*212*TP**WTNN*WTNN\u001C\n" +
                "PI*TS*95992***UP*UP\u001C\n" +
                "LS*800\u001C\n" +
                "LH1*C4*1*UN1005**4904210*LB*156100\u001C\n" +
                "LH2*2.2*P***RQ\u001C\n" +
                "LH3*AMMONIA, ANHYDROUS*D\u001C\n" +
                "LFH*HZC*(AMMONIA)\u001C\n" +
                "LFH*TNM*(ANHYDROUS AMMONIA 82-\u001C\n" +
                "LFH*INH*INHALATION HAZARD\u001C\n" +
                "LE*800\u001C\n" +
                "PER*HM*CF INDUSTRIES*TE*8004249300\u001C\n" +
                "SE*47*495550001\u001C\n" +
                "GE*1*49555\u001C\n" +
                "IEA*1*001914422\u001C\n");
    }

    public void send(String topic, String payload) {
//        System.out.println("sending payload" + payload + ">>" + topic);
        kafkaTemplate.send(topic, payload);
    }
}