import { QuestionManagementsPage } from './app.po';

describe('question-managements App', () => {
  let page: QuestionManagementsPage;

  beforeEach(() => {
    page = new QuestionManagementsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
