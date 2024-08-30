package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entry.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long , JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/abc")
    public List<JournalEntry> getAll() {
          return new ArrayList<>(journalEntries.values());
    }

    @PostMapping("/xyz")
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
      return journalEntries.put(id,myEntry);
    }

}
