package com.tui.quotegarden.utils;

import com.tui.quotegarden.model.Quote;
import com.tui.quotegarden.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseMock {

    @Autowired
    private QuoteRepository quoteRepository;

    public void populateDB() {


        // 10 bill gates

        quoteRepository.save(new Quote(null,
                "5eb17aaeb69dc744b4e7629e",
                "People always fear change. People feared electricity when it was invented, didn't they? People feared coal, they feared gas-powered engines... There will always be ignorance, and ignorance leads to fear. But with time, people will come to accept their silicon masters.",
                "Bill Gates",
                "fear",
                0));

        quoteRepository.save(new Quote(null,
                "5eb17aafb69dc744b4e767c7",
                "If you're using first-class land for biofuels, then you're competing with the growing of food. And so you're actually spiking food prices by moving energy production into agriculture.",
                "Bill Gates",
                "food",
                0));

        quoteRepository.save(new Quote(null,
                "5eb17aafb69dc744b4e767c5",
                "Innovations that are guided by smallholder farmers, adapted to local circumstances, and sustainable for the economy and environment will be necessary to ensure food security in the future.",
                "Bill Gates",
                "food",
                0));

        quoteRepository.save(new Quote(null,
                "5eb17aafb69dc744b4e767c6",
                "We should all grow our own food and do our own waste processing, we really should.",
                "Bill Gates",
                "food",
                0));

        quoteRepository.save(new Quote(null,
                "5eb17aafb69dc744b4e77289",
                "Like almost everyone who uses e-mail, I receive a ton of spam every day. Much of it offers to help me get out of debt or get rich quick. It would be funny if it weren't so exciting.",
                "Bill Gates",
                "funny",
                0));

        quoteRepository.save(new Quote(null,
                "5eb17aafb69dc744b4e775f8",
                "Innovations that are guided by smallholder farmers, adapted to local circumstances, and sustainable for the economy and environment will be necessary to ensure food security in the future.",
                "Bill Gates",
                "future",
                0));
                
        quoteRepository.save(new Quote(null,
                "5eb17aafb69dc744b4e77d6a",
                "If you can't make it good, at least make it look good.",
                "Bill Gates",
                "good",
                0));
                
        quoteRepository.save(new Quote(null,
                "5eb17aafb69dc744b4e7868a",
                "I really had a lot of dreams when I was a kid, and I think a great deal of that grew out of the fact that I had a chance to read a lot.",
                "Bill Gates",
                "great",
                0));
                
        quoteRepository.save(new Quote(null,
                "5eb17aafb69dc744b4e786ff",
                "I'm sorry that we have to have a Washington presence. We thrived during our first 16 years without any of this. I never made a political visit to Washington and we had no people here. It wasn't on our radar screen. We were just making great software.",
                "Bill Gates",
                "great",
                0));
                
        quoteRepository.save(new Quote(null,
                "5eb17aafb69dc744b4e7823d",
                "Well private money can take risks in a way that government money often isn't willing to.",
                "Bill Gates",
                "government",
                0));




        // 5 steve jobs

        quoteRepository.save(new Quote(null,
                "5eb17aaeb69dc744b4e735d7",
                "Well private money can take risks in a way that government money often isn't willing to.",
                "Steve Jobs",
                "computers",
                0));
        quoteRepository.save(new Quote(null,
                "5eb17aaeb69dc744b4e735d5",
                "Computers themselves, and software yet to be developed, will revolutionize the way we learn.",
                "Steve Jobs",
                "computers",
                0));
        quoteRepository.save(new Quote(null,
                "5eb17aaeb69dc744b4e739f5",
                "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma - which is living with the results of other people's thinking. Don't let the noise of others' opinions drown out your own inner voice. And most important, have the courage to follow your heart and intuition.",
                "Steve Jobs",
                "courage",
                0));
        quoteRepository.save(new Quote(null,
                "5eb17aaeb69dc744b4e74109",
                "No one wants to die. Even people who want to go to heaven don't want to die to get there. And yet death is the destination we all share. No one has ever escaped it. And that is as it should be, because Death is very likely the single best invention of Life. It is Life's change agent. It clears out the old to make way for the new.",
                "Steve Jobs",
                "death",
                0));
        
        quoteRepository.save(new Quote(null,
                "5eb17aaeb69dc744b4e74161",
                "Remembering that I'll be dead soon is the most important tool I've ever encountered to help me make the big choices in life. Because almost everything - all external expectations, all pride, all fear of embarrassment or failure - these things just fall away in the face of death, leaving only what is truly important.",
                "Steve Jobs",
                "death",
                0));

    }
}
