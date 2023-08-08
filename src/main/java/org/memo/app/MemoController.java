package org.memo.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemoController {

    @Autowired
    private MemoRepository memoRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Memo> memos = new ArrayList<>();
        memoRepository.findAll().forEach(memos::add);
        model.addAttribute("title", "Home");
        model.addAttribute("memos", memos);
        return "index";
    }

    @GetMapping("/new")
    public String newMemoForm(Model model) {
        model.addAttribute("title", "New");
        return "new";
    }

    @GetMapping("/detail/{id}")
    public String detailMemo(@PathVariable Long id, Model model) {
        Memo memo = memoRepository.findById(id).orElseGet(() -> new Memo());
        model.addAttribute("title", "Detail");
        model.addAttribute("memo", memo);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable Long id, Model model) {
        Memo memo = memoRepository.findById(id).orElseGet(() -> new Memo());
        model.addAttribute("title", "Update");
        model.addAttribute("memo", memo);
        return "update";
    }

    @PostMapping("/new")
    public String postNewMemo(Memo memo) {
        memoRepository.save(memo);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateMemo(@PathVariable Long id, Memo memo) {
        Optional<Memo> getMemo = memoRepository.findById(id);
        if (getMemo.isEmpty()) {
            return String.format("redirect:/update/%l", id);
        }

        memoRepository.save(memo);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteMemo(@PathVariable Long id) {
        if (memoRepository.findById(id).isEmpty()) {
            return "redirect:/";
        }
        memoRepository.deleteById(id);
        return "redirect:/";
    }

}
